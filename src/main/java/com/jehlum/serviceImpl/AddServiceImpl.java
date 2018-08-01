package com.jehlum.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jehlum.daoInterface.AddDaoInterface;
import com.jehlum.models.PostAdd;
import com.jehlum.models.User;
import com.jehlum.serviceInterface.AddServiceInterface;

@Service
@Transactional
public class AddServiceImpl implements AddServiceInterface {
  @Autowired
  AddDaoInterface adddao;
  
  public void save(PostAdd add) {
	  adddao.save(add);
  }
  
  public List<PostAdd> getallAdds(User user){
	  return adddao.getallAdds(user);
  }
  public PostAdd find(Long id) {
	  return adddao.find(id);
  }
  
  public void remove(Long id) {
	   adddao.remove(id);
  }
  public List<PostAdd> getAllJobs(){
	  return adddao.getAllJobs();
  }
}
