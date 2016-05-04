package by.ostis.mihas.interrogator;

import by.ostis.mihas.screquest.usuallrequest.GetLinksByConntentRequest;
import by.ostis.mihas.screquest.usuallrequest.GetNodeByIdRequest;
import by.ostis.mihas.screquest.usuallrequest.MakeLinkScRequest;
import by.ostis.mihas.screquest.usuallrequest.MakeNodeScRequest;
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
        this.interrogator = InterrogatorBuilder.getInstance("192.168.50.155", 55770);
    }

    @After
    public void tearDown() throws IOException {
        interrogator.close();
    }
    @Ignore
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
        interrogator.execute(new GetNodeByIdRequest("ostis"));
    }

    @Test
    public void testGetLinksByConntent() throws IOException, ScRequestException {
        interrogator.execute(new GetLinksByConntentRequest("MIHAS"));
    }

    @Test
    public void testGetLinksByConntentRx() throws IOException, ScRequestException {
        interrogator.execute(new GetLinksByConntentRequest("MIHAS"));
    }
}