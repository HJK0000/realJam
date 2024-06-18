package com.green.restServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restServer.dto.HelpDto;
import com.green.restServer.entity.Help;
import com.green.restServer.repository.HelpRepository;

@Service
public class HelpService {

	@Autowired
	HelpRepository helpRepository;
	
	public void regProcess(HelpDto helpDto) {
		
		Help data = new Help();
		
		data.setTitle(helpDto.getTitle());
		data.setContent(helpDto.getContent());
		
		helpRepository.save(data);
		
	}
	
	public void delete(Long hnum) {
		helpRepository.deleteById(hnum);
	}
	
	public Help findHelpById(Long hnum) {
		Help help = helpRepository.findById(hnum).orElse(null);
		
		return help;
	}
	
	public Help save(Help help) {
		Help savedHelp = helpRepository.save(help);
		
		return savedHelp;
	}
	
	public Help updateHelp(Long hnum, Help help) {
        Help existingHelp = helpRepository.findById(hnum).orElseThrow();
        existingHelp.update(help);
        return helpRepository.save(existingHelp);
    }
	
}
