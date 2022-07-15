package build.buildfarm.common;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class UrlPathTest {

    @Parameters(name = "ResourceName {index}: want({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"compressed-blobs/zstd/ce3d4d77bc12db4605fefbacc54393f78682b24f3656475a7d77837e45b30d93/690" , true },
                {"compressed-blobs/deflate/ce3d4d77bc12db4605fefbacc54393f78682b24f3656475a7d77837e45b30d93/690" , true },
                { "blobs/44b4d2bd797bb05afc352f776212929a2e434903c32c8a738e07ff6e99d25cff/11304", false },
        });
    }

    private String input;
    private boolean want;

    public UrlPathTest(String input, boolean want) {
        this.input = input;
        this.want = want;
    }

    @Test
    public void test() {
        assertEquals(want, UrlPath.isCompressed(input));
    }
}
