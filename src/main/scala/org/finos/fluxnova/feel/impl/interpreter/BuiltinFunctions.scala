/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
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
package org.finos.fluxnova.feel.impl.interpreter

import org.finos.fluxnova.feel.FeelEngineClock
import org.finos.fluxnova.feel.context.FunctionProvider
import org.finos.fluxnova.feel.impl.builtin.{
  BooleanBuiltinFunctions,
  ContextBuiltinFunctions,
  ConversionBuiltinFunctions,
  ListBuiltinFunctions,
  NumericBuiltinFunctions,
  RangeBuiltinFunction,
  StringBuiltinFunctions,
  TemporalBuiltinFunctions
}
import org.finos.fluxnova.feel.syntaxtree.ValFunction
import org.finos.fluxnova.feel.valuemapper.ValueMapper

class BuiltinFunctions(clock: FeelEngineClock, valueMapper: ValueMapper) extends FunctionProvider {

  override def getFunctions(name: String): List[ValFunction] =
    functions.getOrElse(name, List.empty)

  override def functionNames: Iterable[String] = functions.keys

  val functions: Map[String, List[ValFunction]] =
    new ConversionBuiltinFunctions(valueMapper).functions ++
      BooleanBuiltinFunctions.functions ++
      StringBuiltinFunctions.functions ++
      new ListBuiltinFunctions(valueMapper).functions ++
      NumericBuiltinFunctions.functions ++
      new ContextBuiltinFunctions(valueMapper).functions ++
      RangeBuiltinFunction.functions ++
      new TemporalBuiltinFunctions(clock).functions

}
