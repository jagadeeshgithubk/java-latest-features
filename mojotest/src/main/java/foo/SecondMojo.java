package foo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;


@Mojo(name="secondMojoGoal",defaultPhase=LifecyclePhase.PACKAGE)
public class SecondMojo extends AbstractMojo{

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("second Mojo Goal executed");
		
	}
}
