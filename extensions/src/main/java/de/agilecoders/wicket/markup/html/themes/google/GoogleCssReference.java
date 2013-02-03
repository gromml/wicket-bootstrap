package de.agilecoders.wicket.markup.html.themes.google;

import com.google.common.collect.Lists;
import de.agilecoders.wicket.markup.html.themes.bootstrap.BootstrapCssReference;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;

import java.util.List;

/**
 * A google inspired theme
 *
 * @author miha
 */
public class GoogleCssReference extends BootstrapCssReference {
    private static final long serialVersionUID = 1L;

    /**
     * @return singleton instance of {@link GoogleCssReference}
     */
    public static GoogleCssReference instance() {
        return Holder.INSTANCE;
    }

    /**
     * Singleton instance of this reference
     */
    private static final class Holder {
        private static final GoogleCssReference INSTANCE = new GoogleCssReference();
    }

    /**
     * Private constructor.
     */
    private GoogleCssReference() {
        super(GoogleCssReference.class, "css/google-bootstrap.css");
    }

    @Override
    public Iterable<? extends HeaderItem> getDependencies() {
        final List<HeaderItem> dependencies = Lists.newArrayList(super.getDependencies());
        dependencies.add(CssHeaderItem.forReference(BootstrapCssReference.INSTANCE));

        return dependencies;
    }
}