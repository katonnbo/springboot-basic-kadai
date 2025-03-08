package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    // GETリクエストでフォーム画面を表示 (http://localhost:8080/form)
    @GetMapping("/form")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contactFormView";
    }

    // POSTリクエストで確認画面を表示 (http://localhost:8080/form/confirm)
    // バリデーションエラーがあれば、元のフォーム画面に戻す
    @PostMapping("/form/confirm")
    public String confirmContactForm(@Valid @ModelAttribute ContactForm contactForm, BindingResult result) {
        if (result.hasErrors()) {
            return "contactFormView";
        }
        return "confirmView";
    }

    // POSTリクエストで送信完了処理 (http://localhost:8080/form/submit)
    @PostMapping("/form/submit")
    public String submitContactForm(@ModelAttribute ContactForm contactForm) {
        // ここに送信処理（例：DB保存、メール送信など）のロジックを実装する
        // 今回はシンプルに送信完了画面へ遷移します
        return "completeView";
    }
}