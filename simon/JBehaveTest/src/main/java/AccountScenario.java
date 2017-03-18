import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AccountScenario extends JUnitStory {
    @Override
    public Configuration configuration() {
        URL storyURL = null;
        try {
            // This requires you to start Maven from the project directory
            storyURL = new URL("file://" + System.getProperty("user.dir")
                    + "/src/test/stories/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromRelativeFile(storyURL))
                .useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.HTML));
    }

    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new AccountStory())
                .createCandidateSteps();
    }
}