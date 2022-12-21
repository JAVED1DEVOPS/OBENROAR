/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.gui.message;

import org.foodpanda.pdo.MessageType;
import org.foodpanda.pdo.md.User;
import org.foodpanda.pdo.td.Message;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import org.tentackle.bind.Bindable;
import org.tentackle.common.Timestamp;
import org.tentackle.fx.FxControllerService;
import org.tentackle.fx.component.FxChoiceBox;
import org.tentackle.fx.component.FxComboBox;
import org.tentackle.fx.component.FxDatePicker;
import org.tentackle.fx.component.FxTextField;
import org.tentackle.fx.rdc.PdoFinder;
import org.tentackle.fx.translate.DateStringTranslator;
import org.tentackle.common.DateHelper;
import org.tentackle.pdo.DomainContext;

import java.util.List;

/**
 * Finder for messages.
 */
@FxControllerService
public class MessageFinder extends PdoFinder<Message> {

  private Message pdo;    // template


  @Bindable(options = "AUTOSELECT")
  private String number;

  @Bindable(options = "AUTOSELECT")
  private Timestamp from;

  @Bindable(options = "AUTOSELECT")
  private Timestamp until;

  @Bindable
  private MessageType type;

  @Bindable(options = "UC")
  private User user;

  @Bindable
  private String pattern;


  @FXML
  private FxTextField numberField;

  @FXML
  private FxDatePicker fromField;

  @FXML
  private FxDatePicker untilField;

  @FXML
  private FxChoiceBox<MessageType> typeField;

  @FXML
  private FxComboBox<User> userField;

  @FXML
  private FxTextField patternField;



  @Override
  public List<Message> runSearch() {
    return getPdo().findBy(number, from, until, type, user, pattern);
  }

  @Override
  public void requestInitialFocus() {
    numberField.requestFocus();
  }

  @Override
  public ObjectProperty<EventHandler<ActionEvent>> getSearchActionProperty() {
    return patternField.onActionProperty();
  }

  @FXML
  private void initialize() {

    numberField.setOnAction(e -> {
      if (number == null && from == null) {
        from = DateHelper.now(-86400000); // -1 day
        fromField.updateView();
      }
    });

    from = DateHelper.now(-86400000); // -1 day
  }

  @Override
  public void configure() {
    DateStringTranslator.connectAsReferenceDateSuppliers(fromField, untilField);
  }

  @Override
  public Message getPdo() {
    return pdo;
  }

  @Override
  public void setPdo(Message pdo) {
    this.pdo = pdo;
    getBinder().putBindingProperty(DomainContext.class, getDomainContext());
  }

}