package com.example.payment.repostirories;

import com.example.payment.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
