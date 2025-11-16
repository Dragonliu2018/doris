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

package org.apache.doris.common.profile;

import org.apache.doris.common.util.SafeStringBuilder;

import com.google.common.collect.ImmutableMap;


/**
 * 演示工作负载组详细信息输出格式的示例程序
 */
public class WorkloadGroupTestDemo {

    public static void main(String[] args) {
        SummaryProfile profile = new SummaryProfile();

        // 模拟设置工作负载组信息
        profile.update(ImmutableMap.of(
                SummaryProfile.WORKLOAD_GROUP, "normal",
                SummaryProfile.PARSE_SQL_TIME, "1ms",
                SummaryProfile.PLAN_TIME, "78ms"
        ));

        // 生成输出
        SafeStringBuilder builder = new SafeStringBuilder();
        profile.prettyPrint(builder);

        System.out.println("=== 示例输出格式 ===");
        System.out.println(builder.toString());

        System.out.println("\n=== 预期的工作负载组详细信息格式 ===");
        System.out.println("Execution Summary:");
        System.out.println("   - Workload Group: normal");
        System.out.println("   - CPU Share: 1024");
        System.out.println("   - Memory Limit: -1%");
        System.out.println("   - Enable Memory Overcommit: true");
        System.out.println("   - Max Concurrency: 2147483647");
        System.out.println("   - Max Queue Size: 0");
        System.out.println("   - Queue Timeout: 0");
        System.out.println("   - CPU Hard Limit: -1");
        System.out.println("   - Scan Thread Num: -1");
        System.out.println("   - Max Remote Scan Thread Num: -1");
        System.out.println("   - Min Remote Scan Thread Num: -1");
        System.out.println("   - Memory Low Watermark: 50%");
        System.out.println("   - Memory High Watermark: 80%");
        System.out.println("   - Tag: ");
        System.out.println("   - Read Bytes Per Second: -1");
        System.out.println("   - Remote Read Bytes Per Second: -1");
        System.out.println("   - Parse SQL Time: 1ms");
        System.out.println("   - Plan Time: 78ms");
    }
}
