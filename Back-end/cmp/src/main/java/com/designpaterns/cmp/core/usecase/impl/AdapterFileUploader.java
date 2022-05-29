package com.designpaterns.cmp.core.usecase.impl;

import com.designpaterns.cmp.infrastructure.database.model.file.File;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdapterFileUploader implements ManageFileInterface {
    private final ManageProjectUseCase manageProjectUseCase;

    @Override
    public void uploadFile(File file, String projectId) {
        manageProjectUseCase.addFile(file, projectId);
    }

    @Override
    public void removeFile(String fileId, String projectId) {
        manageProjectUseCase.deleteFile(fileId, projectId);
    }

}
