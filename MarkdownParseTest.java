import static org.junit.Assert.*; // Import junit assert
import org.junit.*; // import junit

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

// newline
public class MarkdownParseTest { //markdownparsetest class file

    String[] f;

    @Test // signify that below method is a test
    public void addition() { // the test method
        assertEquals(2, 1 + 1); // the condition that is fulfilled for successful test
    }

    public void setup(String fName) throws Exception {
        f = Files.readString(Path.of(fName)).split("\n");
    }

    @Test
    public void customTest1() throws Exception {
        setup("markdown-files/new.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[sexy.hostname.cool]");
    }

    @Test
    public void customTest2() throws Exception {
        setup("markdown-files/new-file.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[https://nowhere.org, http://IHaveBeenExpectingYou.com, ftp://legithostname.host, https://canvas.ucsd.edu]");
    }

    @Test
    public void customTest3() throws Exception {
        setup("markdown-files/other-case.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[https://link.com]");
    }

    @Test
    public void customTest4() throws Exception {
        setup("markdown-files/othercase.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[https://test.com, ftp://legitname.org, sexy.hostname.here]");
    }

    @Test
    public void customTest5() throws Exception {
        setup("markdown-files/test-file.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[https://something.com, some-page.html]");
    }

    @Test
    public void testDefault1() throws Exception {
        setup("default-files/test-file.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[https://something.com, some-page.html]");
    }

    @Test
    public void testDefault2() throws Exception {
        setup("default-files/test-file2.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[https://something.com, some-page.html]");
    }

    @Test
    public void testDefault3() throws Exception {
        setup("default-files/test-file3.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[]");
    }

    @Test
    public void testDefault4() throws Exception {
        setup("default-files/test-file4.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[]");
    }

    @Test
    public void testDefault5() throws Exception {
        setup("default-files/test-file5.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[]");
    }

    @Test
    public void testDefault6() throws Exception {
        setup("default-files/test-file6.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[]");
    }

    @Test
    public void testDefault7() throws Exception {
        setup("default-files/test-file7.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[]");
    }

    @Test
    public void testDefault8() throws Exception {
        setup("default-files/test-file8.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[]");
    }

    @Test
    public void testEmpty() throws Exception {
        setup("markdown-files/empty.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[]");
    }

    @Test
    public void testAnother() throws Exception {
        setup("markdown-files/another.md");
        ArrayList<String> linksReturned = MarkdownParse.getLinks(f);
        assertEquals(linksReturned.toString(), "[]");
    }

}
