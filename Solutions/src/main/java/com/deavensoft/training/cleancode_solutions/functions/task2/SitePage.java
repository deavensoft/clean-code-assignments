package com.deavensoft.training.cleancode_solutions.functions.task2;


import java.util.Map;


class SitePage {

    private static final String HTTP_EDITABLE_DOMAIN_URL = "https://mysite.com/?edit=true";

    private final String siteGroup;
    private final String userGroup;

    SitePage(String siteGroup, String userGroup) {
        this.siteGroup = siteGroup;
        this.userGroup = userGroup;
    }

    String getEditablePageUrl(Map<String, String> params) {
        return HTTP_EDITABLE_DOMAIN_URL + defineRequestParameters(params) + getAttributes();
    }

    private StringBuilder defineRequestParameters(Map<String, String> params) {
        StringBuilder paramsString = new StringBuilder();

        for (Map.Entry<String, String> parameter : params.entrySet()) {
            paramsString.append(getParamsString(parameter));
        }
        return paramsString;
    }

    private String getParamsString(Map.Entry<String, String> parameter) {
        return "&" + parameter.getKey() + "=" + parameter.getValue();
    }

    private String getAttributes() {
        return "&siteGrp=" + getSiteGroup() + "&userGrp=" + getUserGroup();
    }

    private String getUserGroup() {
        return userGroup;
    }

    private String getSiteGroup() {
        return siteGroup;
    }

}
