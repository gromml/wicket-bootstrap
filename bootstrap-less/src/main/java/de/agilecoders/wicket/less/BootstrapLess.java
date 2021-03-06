package de.agilecoders.wicket.less;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;
import org.apache.wicket.request.resource.IResourceReferenceFactory;
import org.apache.wicket.request.resource.ResourceReferenceRegistry;

/**
 * Bootstrap less compiler settings accessor class
 */
public final class BootstrapLess {

    /**
     * Construct.
     */
    private BootstrapLess() {
        throw new UnsupportedOperationException();
    }

    /**
     * Installs given settings for given application
     *
     * @param app      The current application
     */
    public static void install(final Application app) {

        LessCacheManager cacheManager = new LessCacheManager();
        cacheManager.install(app);

        IPackageResourceGuard resourceGuard = app.getResourceSettings().getPackageResourceGuard();
        if (resourceGuard instanceof SecurePackageResourceGuard) {
            SecurePackageResourceGuard securePackageResourceGuard = (SecurePackageResourceGuard) resourceGuard;
            securePackageResourceGuard.addPattern("+*.less");
        }

        ResourceReferenceRegistry resourceReferenceRegistry = app.getResourceReferenceRegistry();
        IResourceReferenceFactory delegate = resourceReferenceRegistry.getResourceReferenceFactory();
        resourceReferenceRegistry.setResourceReferenceFactory(new LessResourceReferenceFactory(delegate));
    }
}
