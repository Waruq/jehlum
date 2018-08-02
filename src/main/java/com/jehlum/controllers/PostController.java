package com.jehlum.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.jehlum.models.PostAdd;
import com.jehlum.models.User;
import com.jehlum.serviceInterface.AddServiceInterface;
import com.jehlum.serviceInterface.UserServiceInterface;
import com.jehlum.util.Constants;
import com.jehlum.util.StaticMethods;


@Controller
public class PostController {
	
	@Value("${aws.bucketName}")
	private String bucketName;
	
	@Autowired
	AmazonS3Client s3client;
	
	@Autowired
	AddServiceInterface addservice;
	
	@Autowired
	UserServiceInterface userservice;
	
	final static String folder = "jehlum";
	
	@RequestMapping(value="/createAdd")
	public String createAdd(Model model) {
		model.addAttribute("add", new PostAdd());
		return "createAdd";
	}
	
	@RequestMapping(value="/createAdd",method=RequestMethod.POST)
	public String postAdd(PostAdd add,@RequestParam("image") MultipartFile image,@RequestParam("image1") MultipartFile image1,RedirectAttributes model) throws ParseException {
		
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userservice.findByEmail(userDetails.getUsername());
		add.setUser(user);
		add.setPostTime(getIndianDate(new Date()));
		String name1 = null,name2 = null;
		String ext1 = null,ext2 = null;
		if(!image.isEmpty()) {
		 ext1 = image.getContentType();
		 name1 = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext1);
		}
		if(!image1.isEmpty()) {
		  ext2 = image1.getContentType();
		 name2 = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext2);
		}
			
		try {
			System.err.println("image 0 =-----="+image.getInputStream());
			System.err.println("image 1 =-----="+image1.getInputStream());
			System.err.println("itype"+image.getContentType());
			System.err.println();

		} catch (IOException e) {
			e.printStackTrace();
		}
		if(name1!=null) {
				String url = StaticMethods.getImageUrl(Constants.S3_URL, bucketName, folder,name1);
		        add.getFiles().add(url);
		  
		}
		if(name2!=null) {
	        String url = StaticMethods.getImageUrl(Constants.S3_URL, bucketName, folder,name2);
	        add.getFiles().add(url);
		}
		  
		try {
			addservice.save(add);
			if(name1!=null) 
				{
					ObjectMetadata metadata = new ObjectMetadata();
					metadata.setContentType(image.getContentType());
					metadata.setContentLength(image.getSize());
					s3client.setEndpoint(Constants.S3_URL);
		        	s3client.putObject(new PutObjectRequest(bucketName+Constants.SUFFIX+folder,name1,image.getInputStream(), metadata).withCannedAcl(CannedAccessControlList.PublicRead));

				}
			if(name2!=null) 
				{
					ObjectMetadata metadata = new ObjectMetadata();
			        metadata.setContentType(image.getContentType());
			        metadata.setContentLength(image.getSize());
			        s3client.setEndpoint(Constants.S3_URL);
			        s3client.putObject(new PutObjectRequest(bucketName+Constants.SUFFIX+folder,name2,image1.getInputStream(), metadata).withCannedAcl(CannedAccessControlList.PublicRead));

				}
			
			model.addFlashAttribute("success", "Ad Added Sucessfully");
		 }catch(Exception ex) {
			 model.addFlashAttribute("fail", "There Is Some Problem Posting Ad Please Try Again");
		 }
		
		return "redirect:/createAdd";
	}
	
	@RequestMapping(value="viewAllJobs", method=RequestMethod.GET)
	public String viewAllAdds(Model model) {
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userservice.findByEmail(userDetails.getUsername());
		List<PostAdd> adds = addservice.getallAdds(user);
		model.addAttribute("adds", adds);
		return "viewAdds";
	}
	
	@RequestMapping(value="viewAdd/{id}", method=RequestMethod.GET)
	public String viewAdd(Model model,@PathVariable("id") Long id) {
		model.addAttribute("add", addservice.find(id));
		return "view";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteAdd(RedirectAttributes model,@PathVariable("id") Long id) {
		try {
		addservice.remove(id);
		model.addFlashAttribute("success", "Add Deleted Sucessfully");
		}catch(Exception ex) {
			model.addFlashAttribute("fail", "Add Deleted Failed");
		}
	
		return "redirect:/viewAllJobs";
	}
	
	
	 public Date getIndianDate(Date notificationFetchedDate) throws ParseException {
			SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("IST"));
			String date = sdf.format(notificationFetchedDate);
			return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date);
	   }
	 
	 /*@RequestMapping(value = "/getUserImages/{imageName:.+}", method = RequestMethod.GET)
		public void getUserImage(@PathVariable("imageName") String imageName,
				Model model, HttpServletRequest req, HttpServletResponse rep) {
			//String PATH = "/usr/admin/images/";
		
			try {
				// MechanicalEquipment e = mechanicalEquipmentService.find(id);
				System.out.println("imgeName=" + imageName);
				InputStream is = new FileInputStream(path + imageName);

				byte[] bytes = new byte[is.available()];
				if (imageName.contains(".pdf"))
					rep.setContentType("application/pdf");
				else if (imageName.contains(".dwg"))
					rep.setContentType("image/vnd.dwg");
				else if (imageName.contains(".gif"))
					rep.setContentType("image/gif");
				else if (imageName.contains(".png"))
					rep.setContentType("image/png");
				else if (imageName.contains(".jpeg"))
					rep.setContentType("image/jpeg");
				else
					rep.setContentType("image/jpg");
				OutputStream os = rep.getOutputStream();
				os.write(bytes);
				os.close();
				is.close();

			} catch (Exception e) {// e.printStackTrace();
				System.out.println("Image " + imageName + " not present");
				e.printStackTrace();
			}
		}*/

	
	   

}
