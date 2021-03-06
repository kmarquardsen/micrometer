/**
 * Copyright 2017 Pivotal Software, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.cloudwatch;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.MockClock;
import io.micrometer.core.lang.Nullable;
import io.micrometer.core.tck.MeterRegistryCompatibilityKit;

import java.time.Duration;

class CloudWatchMeterRegistryCompatibilityTest extends MeterRegistryCompatibilityKit {
    @Override
    public MeterRegistry registry() {
        //noinspection ConstantConditions
        return new CloudWatchMeterRegistry(new CloudWatchConfig() {
            @Override
            @Nullable
            public String get(String key) {
                return null;
            }

            @Override
            public boolean enabled() {
                return false;
            }

            @Override
            public String namespace() {
                return "DOESNOTMATTER";
            }
        }, new MockClock(), null);
    }

    @Override
    public Duration step() {
        return CloudWatchConfig.DEFAULT.step();
    }
}
