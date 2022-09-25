package org.fasttrackit.invoice.model;

import lombok.With;

@With
public record Invoice(
        String description,
                      double amount,
                      String sender,
                      String receiver,
                      boolean payed) {
}
