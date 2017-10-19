package org.rapidoid.collection;

/*
 * #%L
 * rapidoid-commons
 * %%
 * Copyright (C) 2014 - 2017 Nikolche Mihajlovski and contributors
 * %%
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
 * #L%
 */

import org.rapidoid.RapidoidThing;

public class AbstractDecorator<T> extends RapidoidThing {

	protected volatile T decorated;

	public AbstractDecorator(T decorated) {
		this.decorated = decorated;
	}

	@Override
	public String toString() {
		return decorated.toString();
	}

	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	@Override
	public boolean equals(Object obj) {
		return this == obj || decorated.equals(obj);
	}

	@Override
	public int hashCode() {
		return decorated.hashCode();
	}

	public T decorated() {
		return decorated;
	}

}