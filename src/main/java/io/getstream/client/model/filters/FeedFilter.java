/**

 Copyright (c) 2015, Alessandro Pieri
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 The views and conclusions contained in the software and documentation are those
 of the authors and should not be interpreted as representing official policies,
 either expressed or implied, of the FreeBSD Project.

 */
package io.getstream.client.model.filters;

import com.google.common.base.Joiner;
import io.getstream.client.utils.UriBuilder;

import java.util.List;

/**
 * General filter to filter out activities/follower/following.
 */
public class FeedFilter {

	private final static String PARAM_LIMIT = "limit";
	private final static String PARAM_OFFSET = "offset";
	private final static String PARAM_ID_GREATER_THAN = "id_gt";
	private final static String PARAM_ID_GREATER_THAN_EQUALS = "id_gte";
	private final static String PARAM_ID_LOWER_THAN = "id_lt";
	private final static String PARAM_ID_LOWER_THAN_EQUALS = "id_lte";
	private final static String PARAM_FEED_IDS = "filter";

	private static final int DEFAULT_LIMIT = 25;

	private Integer limit = DEFAULT_LIMIT;
	private Integer offset = null;
	private Integer idGreaterThan = null;
	private Integer idGreaterThanEquals = null;
	private Integer idLowerThanEquals = null;
	private Integer idLowerThan = null;
	private List<String> feedIds = null;

	protected FeedFilter() {
	}

	public int getLimit() {
		return limit;
	}

	public int getOffset() {
		return offset;
	}

	public int getIdGreaterThan() {
		return idGreaterThan;
	}

	public int getIdGreaterThanEquals() {
		return idGreaterThanEquals;
	}

	public int getIdLowerThanEquals() {
		return idLowerThanEquals;
	}

	public int getIdLowerThan() {
		return idLowerThan;
	}

	public List<String> getFeedIds() {
		return feedIds;
	}

	/**
	 * Apply the filter on the given URI.
	 * @param uriBuilder Add attributes to the given {@link UriBuilder}.
	 * @return
	 */
	public UriBuilder apply(UriBuilder uriBuilder) {
		if (null != this.limit) {
			uriBuilder.queryParam(PARAM_LIMIT, this.limit);
		}
		if (null != this.offset) {
			uriBuilder.queryParam(PARAM_OFFSET, this.offset);
		}
		if (null != this.idGreaterThan) {
			uriBuilder.queryParam(PARAM_ID_GREATER_THAN, this.idGreaterThan);
		}
		if (null != this.idGreaterThanEquals) {
			uriBuilder.queryParam(PARAM_ID_GREATER_THAN_EQUALS, this.idGreaterThanEquals);
		}
		if (null != this.idLowerThan) {
			uriBuilder.queryParam(PARAM_ID_LOWER_THAN, this.idLowerThan);
		}
		if (null != this.idLowerThanEquals) {
			uriBuilder.queryParam(PARAM_ID_LOWER_THAN_EQUALS, this.idLowerThanEquals);
		}
		if (null != this.feedIds) {
			uriBuilder.queryParam(PARAM_FEED_IDS, Joiner.on(",").join(this.feedIds));
		}
	 	return uriBuilder;
	}

	/**
	 * Builder to build up a {@link FeedFilter}.
	 */
	public static class Builder {
		protected final FeedFilter feedFilter;

		public Builder() {
			feedFilter = new FeedFilter();
		}

		/**
		 * Create a {@link FeedFilter}.
		 * @return
		 */
		public FeedFilter build() {
			return feedFilter;
		}

		public Builder withLimit(int limit) {
			feedFilter.limit = limit;
			return this;
		}

		public Builder withOffset(int offset) {
			feedFilter.offset = offset;
			return this;
		}

		public Builder withIdGreaterThan(int idGreaterThan) {
			feedFilter.idGreaterThan = idGreaterThan;
			return this;
		}

		public Builder withIdGreaterThanEquals(int idGreaterThanEquals) {
			feedFilter.idGreaterThanEquals = idGreaterThanEquals;
			return this;
		}

		public Builder withIdLowerThanEquals(int idLowerThanEquals) {
			feedFilter.idLowerThanEquals = idLowerThanEquals;
			return this;
		}

		public Builder withIdLowerThan(int idLowerThan) {
			feedFilter.idLowerThan = idLowerThan;
			return this;
		}

		public Builder withFeedIds(List<String> feedIds) {
			feedFilter.feedIds = feedIds;
			return this;
		}
	}
}
