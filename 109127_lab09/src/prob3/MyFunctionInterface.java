package prob3;

@FunctionalInterface
public interface MyFunctionInterface<S,T,L,I> {
 int apply(S s, T t, L l, I i);
}
