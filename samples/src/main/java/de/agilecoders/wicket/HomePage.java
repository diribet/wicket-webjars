package de.agilecoders.wicket;

import de.agilecoders.wicket.webjars.WicketWebjars;
import de.agilecoders.wicket.webjars.request.resource.WebjarsCssResourceReference;
import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);

        add(new Link<Void>("reindex") {
            @Override
            public void onClick() {
                WicketWebjars.reindex(WebApplication.get());
            }
        });
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(JavaScriptHeaderItem.forReference(new WebjarsJavaScriptResourceReference("jquery/current/jquery.min.js")));
        response.render(CssHeaderItem.forReference(new WebjarsCssResourceReference("bootstrap/current/css/bootstrap.css")));
        response.render(CssHeaderItem.forReference(new WebjarsCssResourceReference("bootstrap/current/css/bootstrap-theme.css")));
    }
}
