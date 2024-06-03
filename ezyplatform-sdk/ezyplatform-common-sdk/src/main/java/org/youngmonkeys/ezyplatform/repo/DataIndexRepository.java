/*
 * Copyright 2022 youngmonkeys.org
 * 
 * Licensed under the ezyplatform, Version 1.0.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     https://youngmonkeys.org/licenses/ezyplatform-1.0.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.youngmonkeys.ezyplatform.repo;

import com.tvd12.ezydata.database.EzyDatabaseRepository;
import org.youngmonkeys.ezyplatform.entity.DataIndex;

import java.util.Collection;

public interface DataIndexRepository
    extends EzyDatabaseRepository<Long, DataIndex> {

    void deleteByDataTypeAndDataId(
        String dataType,
        long dataId
    );

    void deleteByDataTypeAndDataIdIn(
        String dataType,
        Collection<Long> dataIds
    );

    DataIndex findByDataTypeAndDataIdAndKeyword(
        String dataType,
        long dataId,
        String keyword
    );
}
