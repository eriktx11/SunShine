/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.model.collection.internal;

import org.gradle.internal.Cast;
import org.gradle.model.internal.core.ChildNodeInitializerStrategy;
import org.gradle.model.internal.core.MutableModelNode;
import org.gradle.model.internal.type.ModelType;

public class ChildNodeInitializerStrategyAccessors {
    public static <T> ChildNodeInitializerStrategyAccessor<T> fromPrivateData() {
        return new ChildNodeInitializerStrategyAccessor<T>() {
            @Override
            public ChildNodeInitializerStrategy<T> getStrategy(MutableModelNode node) {
                return Cast.uncheckedCast(node.getPrivateData(ModelType.of(ChildNodeInitializerStrategy.class)));
            }
        };
    }

    public static <T> ChildNodeInitializerStrategyAccessor<T> constant(final ChildNodeInitializerStrategy<T> strategy) {
        return new ChildNodeInitializerStrategyAccessor<T>() {
            @Override
            public ChildNodeInitializerStrategy<T> getStrategy(MutableModelNode node) {
                return strategy;
            }
        };
    }
}
