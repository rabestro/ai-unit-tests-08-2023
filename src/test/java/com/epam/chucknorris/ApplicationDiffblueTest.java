package com.epam.chucknorris;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ApplicationDiffblueTest {
    /**
     * Method under test: {@link Application#Application(Supplier, Consumer, Function, Function)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     Application.decoder
        //     Application.encoder
        //     Application.input
        //     Application.output

        // Arrange
        // TODO: Populate arranged inputs
        Supplier<String> input = null;
        Consumer<? super String> output = null;
        Function<? super String, String> encoder = null;
        Function<? super String, String> decoder = null;

        // Act
        Application actualApplication = new Application(input, output, encoder, decoder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link Application#run()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRun() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ThreadDeath
        //       at com.epam.chucknorris.Application.requestOperation(Application.java:78)
        //       at java.base/java.util.stream.StreamSpliterators$InfiniteSupplyingSpliterator$OfRef.tryAdvance(StreamSpliterators.java:1358)
        //       at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
        //       at com.epam.chucknorris.Application.run(Application.java:37)
        //   com.diffblue.cover.agent.UnboundedLoopException: Cover agent detected a potentially unbounded loop executing at com.epam.chucknorris.Application#requestOperation:78
        //       at com.epam.chucknorris.Application.requestOperation(Application.java:78)
        //       at java.base/java.util.stream.StreamSpliterators$InfiniteSupplyingSpliterator$OfRef.tryAdvance(StreamSpliterators.java:1358)
        //       at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
        //       at com.epam.chucknorris.Application.run(Application.java:37)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Supplier<String> input = mock(Supplier.class);
        when(input.get()).thenReturn("Get");
        Consumer<String> output = mock(Consumer.class);
        doNothing().when(output).accept(Mockito.<String>any());
        Application application = new Application(input, output, mock(Function.class), mock(Function.class));

        // Act
        application.run();
    }

    /**
     * Method under test: {@link Application#run()}
     */
    @Test
    void testRun2() {
        // Arrange
        Supplier<String> input = mock(Supplier.class);
        when(input.get()).thenReturn("exit");
        Consumer<String> output = mock(Consumer.class);
        doNothing().when(output).accept(Mockito.<String>any());
        Application application = new Application(input, output, mock(Function.class), mock(Function.class));

        // Act
        application.run();

        // Assert that nothing has changed
        verify(input).get();
        verify(output, atLeast(1)).accept(Mockito.<String>any());
    }

    /**
     * Method under test: {@link Application#performEncoding()}
     */
    @Test
    void testPerformEncoding() {
        // Arrange
        Supplier<String> input = mock(Supplier.class);
        when(input.get()).thenReturn("Get");
        Consumer<String> output = mock(Consumer.class);
        doNothing().when(output).accept(Mockito.<String>any());
        Function<String, String> encoder = mock(Function.class);
        when(encoder.apply(Mockito.<String>any())).thenReturn("Apply");
        Application application = new Application(input, output, encoder, mock(Function.class));

        // Act
        application.performEncoding();

        // Assert that nothing has changed
        verify(input).get();
        verify(output, atLeast(1)).accept(Mockito.<String>any());
        verify(encoder).apply(Mockito.<String>any());
    }

    /**
     * Method under test: {@link Application#performDecoding()}
     */
    @Test
    void testPerformDecoding() {
        // Arrange
        Supplier<String> input = mock(Supplier.class);
        when(input.get()).thenReturn("Get");
        Consumer<String> output = mock(Consumer.class);
        doNothing().when(output).accept(Mockito.<String>any());
        Application application = new Application(input, output, mock(Function.class), mock(Function.class));

        // Act
        application.performDecoding();

        // Assert that nothing has changed
        verify(input).get();
        verify(output, atLeast(1)).accept(Mockito.<String>any());
    }

    /**
     * Method under test: {@link Application#isEncodedStringInvalid(String)}
     */
    @Test
    void testIsEncodedStringInvalid() {
        // Arrange
        Application application = new Application(mock(Supplier.class), mock(Consumer.class), mock(Function.class),
                mock(Function.class));
        String encodedString = "secret";

        // Act
        boolean actualIsEncodedStringInvalidResult = application.isEncodedStringInvalid(encodedString);

        // Assert
        assertTrue(actualIsEncodedStringInvalidResult);
    }
}
