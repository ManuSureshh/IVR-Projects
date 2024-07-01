package flow.subflow.Offer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.vis.club.mahindra.api.model.LoadMemberCampaignOffer;
import org.vis.club.mahindra.api.model.MemberID;
import org.vis.club.mahindra.api.model.MemberInformationReq;
import org.vis.club.mahindra.api.model.Offers;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.google.gson.Gson;

import flow.IProjectVariables;

/**
 * A basic servlet which allows a user to define their code, generate
 * any output, and to select where to transition to next.
 * Last generated by Orchestration Designer at: 2023-APR-11  02:26:56 PM
 */
public class GetOffers extends com.avaya.sce.runtime.BasicServlet {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2023-APR-11  02:26:56 PM
	 */
	public GetOffers() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * This method allows for custom integration with other Java components.
	 * You may use Java for sophisticated logic or to integrate with custom
	 * connectors (i.e. JMS, custom web services, sockets, XML, JAXB, etc.)
	 *
	 * Any custom code added here should work as efficiently as possible to prevent delays.
	 * It's important to design your callflow so that the voice browser (Experienve Portal/IR)
	 * is not waiting too long for a response as this can lead to a poor caller experience.
	 * Additionally, if the response to the client voice browser exceeds the configured
	 * timeout, the platform may throw an "error.badfetch". 
	 *
	 * Using this method, you have access to all session variables through the 
	 * SCESession object.
	 *
	 * The code generator will *** NOT *** overwrite this method in the future.
	 * Last generated by Orchestration Designer at: 2023-APR-11  02:26:56 PM
	 */
	public void servletImplementation(com.avaya.sce.runtimecommon.SCESession mySession) {

		getMemberOffers(mySession);

	}
	
	private void getMemberOffers(SCESession mySession) {

		BufferedReader rd = null;
		Offers offerResp = null;
		Gson gson = new Gson();

		String info = "";
		String jsonResponse = "";
		try {
			String config = getServletContext().getInitParameter("Configuration");

			Properties properties = loadPropertyFile(config);
			HttpClient client = HttpClientBuilder.create().build();
			String appURL = properties.getProperty("localhost_url")
					.concat(properties.getProperty("localhost_app_name"));
			String OffURL = appURL.concat(properties.getProperty("offers_url"));

			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offers URL : " + OffURL);

			String memberID = mySession.getVariableField(IProjectVariables.MEMBER_DETAILS,
					IProjectVariables.MEMBER_DETAILS_FIELD_MEMBER_ID).getStringValue();

			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offer Flow | memberID : " + memberID);

			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offer Flow | URL: " + OffURL);

			HttpPost post = new HttpPost(OffURL);
			post.addHeader("Content-Type", "application/json");

//			StringEntity stringEntity = new StringEntity(
//					"{" + " \"MemberId\":\"" + memberID + "	}");
			
			
			MemberID memberInformationReq=new MemberID();
			memberInformationReq.setMemberID(memberID);
			
			String json = gson.toJson(memberInformationReq);
			
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offers | "
					+ "Offers| Offers json req : " + json);
			
			StringEntity stringEntity=new StringEntity(json);			
			
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO,
					"Offers  | member id: "+memberID);

			post.setEntity(stringEntity);

			HttpResponse response = client.execute(post);

			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			while ((info = rd.readLine()) != null) {
				jsonResponse += (info);
			}
			
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offer jsonResponse: " + jsonResponse);

			offerResp = gson.fromJson(jsonResponse, Offers.class);
			
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offer Response: " + offerResp);

//			String responseMessage = offerResp.getResponseMessage();
			String annOffers="offers_menu_ann.wav*";

			if (offerResp != null && offerResp.getResponseMessage() != null 
					&& offerResp.getResponseMessage().equalsIgnoreCase("Success")) {
				mySession.getVariableField(IProjectVariables.OFFER, IProjectVariables.OFFER_FIELD_IS_REQ_SUCCESS)
						.setValue(true);

				if (!offerResp.getLoadMemberCampaignOffers().isEmpty()) {
					ArrayList<LoadMemberCampaignOffer> loadMemberCampaignOffers = offerResp
							.getLoadMemberCampaignOffers();

					if (loadMemberCampaignOffers != null && !loadMemberCampaignOffers.isEmpty()) {

						for (LoadMemberCampaignOffer loadMemberCampaignOffer : loadMemberCampaignOffers) {
							annOffers += getAudioFileName(
									loadMemberCampaignOffer.getOfferName(), mySession, properties)+ "*silence_1500.wav*";
						}
						
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO,
								"Offer Flow Response | Offer Load Member offer: "+annOffers);
					} else {
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO,
								"Offer Flow Response | Offer Load Member doesnt have data ");
					}
				} else {
					mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO,
							"Offer Flow Response | Offer Load Member offer is null ");
				}
				mySession.getVariableField(IProjectVariables.OFFER, IProjectVariables.OFFER_FIELD_ANNOUNCE_OFFERS)
						.setValue(annOffers);

			} else {
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO,
						"Offer Flow Response | Offer Load Member offer api response is null ");
				mySession.getVariableField(IProjectVariables.OFFER, IProjectVariables.OFFER_FIELD_IS_REQ_SUCCESS)
						.setValue(false);
			}

		} catch (IOException e) {
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO,
					"Offer Flow Response | Exception While Getting the details of Offer Flow Response " + e);
		} finally {
			try {
				rd.close();
			} catch (IOException e) {
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO,
						"Offer Flow Response | Exception While Closing Buffered Reader " + e);
			}
		}

	}
	
	
	/**
     * @param config 
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
	private static Properties loadPropertyFile(String config) throws FileNotFoundException, IOException {
		FileReader reader = null;
		reader = new FileReader(config);
		Properties properties = new Properties();
		properties.load(reader);
		return properties;
	}
	
	private String getAudioFileName(String audioKey, SCESession mySession, Properties properties) {
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, 
				"Offers| Audio key : " + audioKey);
		String audioFileName = null;
		
		Enumeration<Object> keys = properties.keys();
		
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, 
				"Offers | Property Keys List : " + keys);
		
		if (keys!=null) {
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Property Keys |  key : " + key);

				audioKey = audioKey.replace(" ", "_").trim();

				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO,
						"Offers | Property Keys List : " + audioKey);

				if (key != null && audioKey != null && audioKey.toLowerCase().contains(key.toLowerCase())) {
					audioFileName = properties.getProperty(key);
				}
			} 
		} else {
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, 
					"Offers | there is no keys in property file : " + keys);
		}
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, 
				"Offers | Audio FileName : " + audioFileName);
		return audioFileName;
	}
	
	
	/**
	 * Builds the list of branches that are defined for this servlet object.
	 * This list is built automatically by defining Goto nodes in the call flow editor.
	 * It is the programmer's responsibilty to provide at least one enabled Goto.<BR>
	 *
	 * The user should override updateBranches() to determine which Goto that the
	 * framework will activate.  If there is not at least one enabled Goto item, 
	 * the framework will throw a runtime exception.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.  To modify the list
	 * of branches for the flow item, override:
	 *     <code>updateBranches(Collection branches, SCESession mySession)</code>
	 *
	 * @return a Collection of <code>com.avaya.sce.runtime.Goto</code>
	 * objects that will be evaluated at runtime.  If there are no gotos
	 * defined in the Servlet node, then this returns null.
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:24 PM
	 */
	public java.util.Collection getBranches(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Goto aGoto = null;
		list = new java.util.ArrayList(1);

		aGoto = new com.avaya.sce.runtime.Goto("Offer-UserSel", 0, true, "Default");
		list.add(aGoto);

		return list;
	}
}
