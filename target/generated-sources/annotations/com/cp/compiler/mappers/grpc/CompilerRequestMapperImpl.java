package com.cp.compiler.mappers.grpc;

import com.cp.compiler.contract.CompilerProto;
import com.cp.compiler.contract.RemoteCodeCompilerRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-17T10:40:57+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class CompilerRequestMapperImpl implements CompilerRequestMapper {

    @Override
    public RemoteCodeCompilerRequest toCompilerRequest(CompilerProto.RemoteCodeCompilerRequest protoRequest) {
        if ( protoRequest == null ) {
            return null;
        }

        RemoteCodeCompilerRequest remoteCodeCompilerRequest = new RemoteCodeCompilerRequest();

        remoteCodeCompilerRequest.setTestCases( CompilerRequestMapper.toTestCases( protoRequest.getTestCases() ) );
        remoteCodeCompilerRequest.setLanguage( CompilerRequestMapper.toLanguage( protoRequest.getLanguage() ) );
        remoteCodeCompilerRequest.setMemoryLimit( protoRequest.getMemoryLimit() );
        remoteCodeCompilerRequest.setSourcecode( protoRequest.getSourcecode() );
        remoteCodeCompilerRequest.setTimeLimit( protoRequest.getTimeLimit() );

        return remoteCodeCompilerRequest;
    }
}
