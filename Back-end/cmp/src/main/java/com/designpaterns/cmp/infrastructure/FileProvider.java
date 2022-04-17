package com.designpaterns.cmp.infrastructure;

import java.util.Optional;

import com.designpaterns.cmp.infrastructure.database.model.file.File;
import com.designpaterns.cmp.infrastructure.database.model.file.FileRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileProvider {

	private final FileRepository fileRepository;

	public void save(final File file){
		fileRepository.save(file);
	}

	public void deleteById(final String fileId){
		fileRepository.deleteById(fileId);
	}

	public Optional<File> findById(final String fileId){
		return fileRepository.findById(fileId);
	}





}
