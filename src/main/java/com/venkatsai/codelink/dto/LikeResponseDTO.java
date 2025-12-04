package com.venkatsai.codelink.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponseDTO {
    private Long postId;
    private Long userId;}
