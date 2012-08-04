package de.agilecoders.wicket.markup.html.bootstrap.common;

import de.agilecoders.wicket.markup.html.bootstrap.dialog.Alert;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.Duration;

/**
 * TODO: document
 *
 * @author miha
 * @version 1.0
 */
public class NotificationPanel extends FeedbackPanel {

    private Duration duration;

    public NotificationPanel(String id) {
        super(id);
    }

    public NotificationPanel(String id, IFeedbackMessageFilter filter) {
        super(id, filter);
    }

    public NotificationPanel hideAfter(Duration duration) {
        this.duration = duration;
        return this;
    }

    @Override
    protected String getCSSClass(FeedbackMessage message) {
        return null;
    }

    @Override
    protected Component newMessageDisplayComponent(String id, FeedbackMessage message) {
        if (message.getMessage() instanceof NotificationMessage) {
            NotificationMessage notificationMessage = (NotificationMessage) message.getMessage();

            return new Alert(id, notificationMessage.message(), notificationMessage.header())
                    .type(Alert.Type.from(message.getLevelAsString()))
                    .hideAfter(notificationMessage.hideAfter() == null ? duration : notificationMessage.hideAfter())
                    .useInlineHeader(notificationMessage.inlineHeader());
        }

        return new Alert(id, Model.of(message.getMessage().toString()))
                .hideAfter(duration)
                .type(Alert.Type.from(message.getLevelAsString()));
    }
}