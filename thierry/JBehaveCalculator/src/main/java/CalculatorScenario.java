import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.net.URL;
import java.util.List;

public class CalculatorScenario extends JUnitStory {
    @Override
    public Configuration configuration() {
        URL storyURL = null;

        try {
            storyURL = getClass().getClassLoader().getResource("");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromRelativeFile(storyURL))
                .useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.HTML));
    }

    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new CalculatorStory())
                .createCandidateSteps();
    }
}