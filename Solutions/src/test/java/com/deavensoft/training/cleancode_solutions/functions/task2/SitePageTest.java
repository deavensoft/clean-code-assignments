package com.deavensoft.training.cleancode_solutions.functions.task2;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

class SitePageTest {

    @Test
    void shouldGenerateUrlWithEmptyParams() {
        assertEquals("https://mysite.com/?edit=true&siteGrp=default&userGrp=admin",
                new SitePage("default", "admin").getEditablePageUrl(new LinkedHashMap<>()));
    }

    @Test
    void shouldGenerateUrlWithSeveralParams() {
        assertEquals(
                "https://mysite.com/?edit=true&id=1234&user=Alex&redirect=true&siteGrp=mySite&userGrp=std",
                new SitePage("mySite", "std").getEditablePageUrl(new LinkedHashMap<>() {{
                    put("id", "1234");
                    put("user", "Alex");
                    put("redirect", "true");
                }}));
    }
}