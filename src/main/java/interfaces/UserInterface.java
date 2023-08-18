package interfaces;

import in.fssa.knfunding.model.User;

public interface UserInterface extends Base<User> {
	public abstract User findByEmail(String email);

	public abstract int count();
}
