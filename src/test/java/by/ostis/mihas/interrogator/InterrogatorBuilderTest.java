package by.ostis.mihas.interrogator;

import by.ostis.mihas.screquest.GetLinksByConntent;
import by.ostis.mihas.screquest.GetNodeById;
import by.ostis.mihas.screquest.MakeLinkScRequest;
import by.ostis.mihas.screquest.MakeNodeScRequest;
import by.ostis.mihas.screquest.exception.ScRequestException;
import model.scparametr.scelementtype.ScNodeType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class InterrogatorBuilderTest {
    private Interrogator interrogator;

    @Before
    public void setUp() throws IOException {
        this.interrogator = InterrogatorBuilder.getInstance("192.168.50.154", 55770);
    }

    @After
    public void tearDown() throws IOException {
        interrogator.close();
    }

    @Test
    public void testMakeNode() throws IOException, ScRequestException {
        interrogator.execute(new MakeNodeScRequest("ostis", new ScNodeType()));
    }

    @Ignore
    @Test
    public void testMakeLink() throws IOException, ScRequestException {
        interrogator.execute(new MakeLinkScRequest("MIHAS"));
    }

    @Test
    public void testGetNodeById() throws IOException, ScRequestException {
        interrogator.execute(new GetNodeById("ostis"));
    }

    @Test
    public void testGetLinksByConntent() throws IOException, ScRequestException {
        interrogator.execute(new GetLinksByConntent("MIHAS"));
    }
}