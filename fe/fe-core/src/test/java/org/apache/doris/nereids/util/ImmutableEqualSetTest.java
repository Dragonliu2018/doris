// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.util;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmutableEqualSetTest {
    @Test
    void testRemoveCircle() {
        ImmutableEqualSet.Builder<Integer> builder = new ImmutableEqualSet.Builder<>();
        builder.addEqualPair(1, 2);
        builder.addEqualPair(2, 3);
        builder.addEqualPair(3, 1);
        builder.removeNotContain(Sets.newHashSet(1, 3));
        ImmutableEqualSet<Integer> e = builder.build();
        Assertions.assertTrue(e.isEqual(1, 3));
    }

    @Test
    void testRemoveInTree() {
        ImmutableEqualSet.Builder<Integer> builder = new ImmutableEqualSet.Builder<>();
        builder.addEqualPair(1, 2);
        builder.addEqualPair(2, 3);
        builder.addEqualPair(2, 4);
        builder.removeNotContain(Sets.newHashSet(1, 3, 4));
        ImmutableEqualSet<Integer> e = builder.build();
        Assertions.assertTrue(e.isEqual(3, 4));
        Assertions.assertTrue(e.isEqual(1, 3));
        Assertions.assertTrue(e.isEqual(1, 4));
    }

    @Test
    void testRemoveInTrans() {
        ImmutableEqualSet.Builder<Integer> builder = new ImmutableEqualSet.Builder<>();
        builder.addEqualPair(1, 2);
        builder.addEqualPair(2, 3);
        builder.addEqualPair(3, 4);
        builder.removeNotContain(Sets.newHashSet(1, 4));
        ImmutableEqualSet<Integer> e = builder.build();
        Assertions.assertTrue(e.isEqual(1, 4));
    }
}
