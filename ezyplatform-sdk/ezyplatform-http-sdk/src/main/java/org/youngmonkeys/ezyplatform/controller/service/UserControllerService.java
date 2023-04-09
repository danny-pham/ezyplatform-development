/*
 * Copyright 2023 youngmonkeys.org
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

package org.youngmonkeys.ezyplatform.controller.service;

import lombok.AllArgsConstructor;
import org.youngmonkeys.ezyplatform.model.PaginationModel;
import org.youngmonkeys.ezyplatform.model.UserModel;
import org.youngmonkeys.ezyplatform.pagination.UserFilter;
import org.youngmonkeys.ezyplatform.pagination.UserPaginationParameterConverter;
import org.youngmonkeys.ezyplatform.pagination.UserPaginationSortOrder;
import org.youngmonkeys.ezyplatform.service.PaginationUserService;

import static org.youngmonkeys.ezyplatform.pagination.PaginationModelFetchers.getPaginationModel;

@AllArgsConstructor
public class UserControllerService {

    private final PaginationUserService paginationUserService;
    private final UserPaginationParameterConverter userPaginationParameterConverter;

    public PaginationModel<UserModel> getUserPagination(
        UserFilter filter,
        String nextPageToken,
        String prevPageToken,
        boolean lastPage,
        int limit
    ) {
        String actualNextPageToken = nextPageToken;
        String actualPrevPageToken = prevPageToken;
        UserPaginationSortOrder sortOrder = UserPaginationSortOrder.ID_DESC;
        if (nextPageToken == null && prevPageToken == null) {
            if (lastPage) {
                actualPrevPageToken = userPaginationParameterConverter
                    .getDefaultPageToken(sortOrder.toString());
            } else {
                actualNextPageToken = userPaginationParameterConverter
                    .getDefaultPageToken(sortOrder.toString());
            }
        }
        return getPaginationModel(
            paginationUserService,
            filter,
            actualNextPageToken,
            actualPrevPageToken,
            lastPage,
            limit
        );
    }
}
