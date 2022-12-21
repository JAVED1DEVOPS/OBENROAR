/*
 * foodpanda generated by tentackle-project-archetype.
 */

/**
 * FX GUI module.
 */
open module org.foodpanda.gui {
  exports org.foodpanda.gui;
  exports org.foodpanda.gui.main;

  requires org.foodpanda.pdo;

  requires org.tentackle.fx.rdc;

  requires java.prefs;

  provides org.tentackle.common.ModuleHook with org.foodpanda.gui.service.Hook;
}