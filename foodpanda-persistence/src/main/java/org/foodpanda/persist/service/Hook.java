/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.persist.service;

import org.tentackle.common.ModuleHook;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hook for the persistence module.
 */
public class Hook implements ModuleHook {

  @Override
  public ResourceBundle getBundle(String baseName, Locale locale) {
    return ResourceBundle.getBundle(baseName, locale);
  }

}