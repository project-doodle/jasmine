/*
 * Copyright (c) 2022-present Doodle. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package doodle.jasmine.sbe.thinkingdata.tga.plus;

import cn.thinkingdata.tga.javasdk.ThinkingDataAnalytics;
import java.util.Map;
import java.util.Objects;

public final class TGAPlusTracker {
  private final ThinkingDataAnalytics tga;

  public TGAPlusTracker(ThinkingDataAnalytics tga) {
    this.tga = Objects.requireNonNull(tga);
  }

  public void track(
      Object opaque,
      String accountId,
      String distinctId,
      String eventName,
      Map<String, Object> properties) {
    try (TGAPlusOpaqueContext ignored = new TGAPlusOpaqueContext(opaque)) {
      this.tga.track(accountId, distinctId, eventName, properties);
    } catch (Throwable ignored) {
    }
  }

  public void track_first(
      Object opaque,
      String accountId,
      String distinctId,
      String eventName,
      Map<String, Object> properties) {
    try (TGAPlusOpaqueContext ignored = new TGAPlusOpaqueContext(opaque)) {
      this.tga.track_first(accountId, distinctId, eventName, properties);
    } catch (Throwable ignored) {
    }
  }

  public void track_update(
      Object opaque,
      String accountId,
      String distinctId,
      String eventName,
      String eventId,
      Map<String, Object> properties) {
    try (TGAPlusOpaqueContext ignored = new TGAPlusOpaqueContext(opaque)) {
      this.tga.track_update(accountId, distinctId, eventName, eventId, properties);
    } catch (Throwable ignored) {
    }
  }

  public void track_override(
      Object opaque,
      String accountId,
      String distinctId,
      String eventName,
      String eventId,
      Map<String, Object> properties) {
    try (TGAPlusOpaqueContext ignored = new TGAPlusOpaqueContext(opaque)) {
      this.tga.track_overwrite(accountId, distinctId, eventName, eventId, properties);
    } catch (Throwable ignored) {
    }
  }
}
