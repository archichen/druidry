/*
 * Copyright 2018-present Red Brick Lane Marketing Solutions Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package in.zapr.druid.druidry.query.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import in.zapr.druid.druidry.dataSource.DataSource;
import in.zapr.druid.druidry.query.QueryType;
import in.zapr.druid.druidry.query.config.Interval;
import in.zapr.druid.druidry.query.scan.ResultFormat;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
public
class DruidSegmentMetadataQuery extends DruidMetadataQuery {
    public List<Interval> intervals;
    public String toInclude;
    public String merge;
    public String analysisTypes;
    public String lenientAggregatorMerge;
    private ResultFormat resultFormat;

    @Builder
    public DruidSegmentMetadataQuery(
            List<Interval> intervals,
            String toInclude,
            String merge,
            String analysisTypes,
            String lenientAggregatorMerge,
            ResultFormat resultFormat,
            @NonNull DataSource dataSource
    ) {
        this.queryType = QueryType.SEGMENT_METADATA;
        this.dataSource = dataSource;
        this.intervals = intervals;
        this.toInclude = toInclude;
        this.merge = merge;
        this.analysisTypes = analysisTypes;
        this.lenientAggregatorMerge = lenientAggregatorMerge;
        this.resultFormat = resultFormat;
    }
}
