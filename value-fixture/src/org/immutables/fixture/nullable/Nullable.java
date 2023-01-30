package org.immutables.fixture.nullable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This mimics @{code org.jetbrains.annotations.Nullable}.
 *
 * @see <a
 *     href="https://github.com/JetBrains/java-annotations/blob/c36487a61ea833c057b62ea43d934478ba4c545a/common/src/main/java/org/jetbrains/annotations/Nullable.java">Jetbrains
 *     Annotations Nullable</a>
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({
  ElementType.METHOD,
  ElementType.FIELD,
  ElementType.PARAMETER,
  ElementType.LOCAL_VARIABLE,
  ElementType.TYPE_USE
})
public @interface Nullable {
  String value() default "";
}
