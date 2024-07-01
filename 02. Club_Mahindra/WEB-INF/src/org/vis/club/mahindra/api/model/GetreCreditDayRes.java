package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class GetreCreditDayRes {
    @SerializedName("Recredit_Points")
    public String recredit_Points;

    public String getRecredit_Points() {
	return recredit_Points;
    }

    @Override
    public String toString() {
	return "GetreCreditDayRes [recredit_Points=" + recredit_Points + "]";
    }

}
