import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

println("** Creating admin user and disabling setup wizard **")

// Disable setup wizard
def env = System.getenv()
instance.getInjector().getInstance(jenkins.install.InstallState.Initializer.class).installState = jenkins.install.InstallState.INITIAL_SETUP_COMPLETED

// Create admin user
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin','admin')
instance.setSecurityRealm(hudsonRealm)

// Full control once logged in
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

instance.save()
println("** Admin user 'admin' created with password 'admin' **")
