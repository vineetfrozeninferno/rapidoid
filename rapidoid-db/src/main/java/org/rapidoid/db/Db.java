package org.rapidoid.db;

/*
 * #%L
 * rapidoid-db
 * %%
 * Copyright (C) 2014 Nikolche Mihajlovski
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

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.rapidoid.activity.Activity;
import org.rapidoid.lambda.Operation;
import org.rapidoid.lambda.Predicate;

public interface Db extends Activity<Db> {

	long insert(Object record);

	<E> E get(long id);

	<E> E get(long id, Class<E> clazz);

	<E> List<E> getAll(Class<E> clazz);

	<E> List<E> getAll(long... ids);

	<E> List<E> getAll(Collection<Long> ids);

	void update(Object record);

	void update(long id, Object record);

	long persist(Object record);

	void delete(long id);

	<T> T read(long id, String column);

	<E> List<E> find(Predicate<E> match);

	<E> List<E> find(String searchPhrase);

	<E> void each(Operation<E> lambda);

	void transaction(Runnable transaction);

	void transaction(Runnable transaction, Runnable onCommit, Runnable onRollback);

	void saveTo(OutputStream output);

	void load(InputStream in);

	long size();

	void destroy();

	long getIdOf(Object record);

}
