package com.jehlum.daoInterface;

import java.util.List;

import com.jehlum.models.PostAdd;
import com.jehlum.models.User;

public interface AddDaoInterface {
	public void save(PostAdd add);
	public List<PostAdd> getallAdds(User user);
	public PostAdd find(Long id); 
	public void remove(Long id) ;
	public List<PostAdd> getAllJobs();
}
