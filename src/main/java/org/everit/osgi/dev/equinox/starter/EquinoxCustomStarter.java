/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.biz)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.osgi.dev.equinox.starter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.adaptor.EclipseStarter;

/**
 * An Equinox starter class that registers a shutdown hook to stop the framework properly.
 */
public final class EquinoxCustomStarter {

  public static final Logger LOGGER = Logger.getLogger(EquinoxCustomStarter.class.getName());

  /**
   * Main method to register the shutdown hook to stop the framework and start it.
   */
  public static void main(final String[] args) throws Exception {

    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          EclipseStarter.shutdown();
        } catch (Exception e) {
          LOGGER.log(Level.SEVERE, "Failed to shutdown Equinox framework.", e);
        }
      }

    }));

    EclipseStarter.main(args);

  }

  private EquinoxCustomStarter() {
  }
}
