package org.immutables.fixture.nullable;

import org.immutables.value.Value;

@Value.Immutable
public interface NullableOnContainingClass {
  @Nullable
  OuterClass.InnerClass annotatesEnclosingInstanceTypeInnerClass();

  OuterClass.@Nullable InnerClass annotatesInnerClass();

  @Nullable
  OuterClass.StaticNestedClass annotatesEnclosingInstanceTypeStaticNestedClass();

  OuterClass.@Nullable StaticNestedClass annotatesStaticNestedClassType();
}
