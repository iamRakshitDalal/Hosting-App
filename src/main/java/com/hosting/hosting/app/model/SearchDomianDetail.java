package com.hosting.hosting.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDomianDetail {
    private String domainName;
    private boolean available;
    private float price;
}
