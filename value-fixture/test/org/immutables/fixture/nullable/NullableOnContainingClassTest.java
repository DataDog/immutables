package org.immutables.fixture.nullable;

import static org.immutables.check.Checkers.check;

import org.junit.jupiter.api.Test;

/* See https://errorprone.info/bugpattern/NullableOnContainingClass. */
public class NullableOnContainingClassTest {
  private static final OuterClass.InnerClass INNER_CLASS_TYPE_INSTANCE =
      new OuterClass().new InnerClass();
  private static final OuterClass.StaticNestedClass STATIC_NESTED_CLASS_TYPE_INSTANCE =
      new OuterClass.StaticNestedClass();

  @Test
  public void allowNullableInnerClass() {
    ImmutableNullableOnContainingClass immutableAnnotateInnerClass =
        ImmutableNullableOnContainingClass.builder()
            .annotatesEnclosingInstanceTypeInnerClass(INNER_CLASS_TYPE_INSTANCE)
            .annotatesInnerClass(null)
            .annotatesEnclosingInstanceTypeStaticNestedClass(STATIC_NESTED_CLASS_TYPE_INSTANCE)
            .annotatesStaticNestedClassType(STATIC_NESTED_CLASS_TYPE_INSTANCE)
            .build();

    check(immutableAnnotateInnerClass.annotatesEnclosingInstanceTypeInnerClass())
        .is(INNER_CLASS_TYPE_INSTANCE);
    check(immutableAnnotateInnerClass.annotatesInnerClass()).isNull();
    check(immutableAnnotateInnerClass.annotatesEnclosingInstanceTypeStaticNestedClass())
        .is(STATIC_NESTED_CLASS_TYPE_INSTANCE);
    check(immutableAnnotateInnerClass.annotatesStaticNestedClassType())
        .is(STATIC_NESTED_CLASS_TYPE_INSTANCE);
  }

  @Test
  public void allowNullableStaticNestedClass() {
    ImmutableNullableOnContainingClass immutableAnnotateInnerClass =
        ImmutableNullableOnContainingClass.builder()
            .annotatesEnclosingInstanceTypeInnerClass(INNER_CLASS_TYPE_INSTANCE)
            .annotatesInnerClass(INNER_CLASS_TYPE_INSTANCE)
            .annotatesEnclosingInstanceTypeStaticNestedClass(STATIC_NESTED_CLASS_TYPE_INSTANCE)
            .annotatesStaticNestedClassType(null)
            .build();

    check(immutableAnnotateInnerClass.annotatesEnclosingInstanceTypeInnerClass())
        .is(INNER_CLASS_TYPE_INSTANCE);
    check(immutableAnnotateInnerClass.annotatesInnerClass()).is(INNER_CLASS_TYPE_INSTANCE);
    check(immutableAnnotateInnerClass.annotatesEnclosingInstanceTypeStaticNestedClass())
        .is(STATIC_NESTED_CLASS_TYPE_INSTANCE);
    check(immutableAnnotateInnerClass.annotatesStaticNestedClassType()).isNull();
  }

  @Test
  public void allowEnclosingNullables() {
    ImmutableNullableOnContainingClass immutableAnnotateInnerClass =
        ImmutableNullableOnContainingClass.builder()
            .annotatesEnclosingInstanceTypeInnerClass(null)
            .annotatesInnerClass(INNER_CLASS_TYPE_INSTANCE)
            .annotatesEnclosingInstanceTypeStaticNestedClass(null)
            .annotatesStaticNestedClassType(STATIC_NESTED_CLASS_TYPE_INSTANCE)
            .build();

    check(immutableAnnotateInnerClass.annotatesEnclosingInstanceTypeInnerClass()).isNull();
    check(immutableAnnotateInnerClass.annotatesInnerClass()).is(INNER_CLASS_TYPE_INSTANCE);
    check(immutableAnnotateInnerClass.annotatesEnclosingInstanceTypeStaticNestedClass()).isNull();
    check(immutableAnnotateInnerClass.annotatesStaticNestedClassType())
        .is(STATIC_NESTED_CLASS_TYPE_INSTANCE);
  }

  @Test
  public void allowNulls() {
    ImmutableNullableOnContainingClass immutableAnnotateInnerClass =
        ImmutableNullableOnContainingClass.builder()
            .annotatesEnclosingInstanceTypeInnerClass(null)
            .annotatesInnerClass(null)
            .annotatesEnclosingInstanceTypeStaticNestedClass(null)
            .annotatesStaticNestedClassType(null)
            .build();

    check(immutableAnnotateInnerClass.annotatesEnclosingInstanceTypeInnerClass()).isNull();
    check(immutableAnnotateInnerClass.annotatesInnerClass()).isNull();
    check(immutableAnnotateInnerClass.annotatesEnclosingInstanceTypeStaticNestedClass()).isNull();
    check(immutableAnnotateInnerClass.annotatesStaticNestedClassType()).isNull();
  }
}
