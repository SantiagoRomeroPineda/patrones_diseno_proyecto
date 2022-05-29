package com.designpaterns.cmp.core.usecase.impl;

import com.designpaterns.cmp.infrastructure.database.model.file.File;

public interface ManageFileInterface {
    public void uploadFile(File file, String projectId);

    public void removeFile(String fileId, String projectId);
}
