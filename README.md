# Mini-Bank
## Pomysł 5: Mini Bank — konta, transakcje, karty

Cel: prosty system bankowy obsługujący różne typy kont, transakcje i karty; zasady autoryzacji i limity.

### Lista kontrolna
1. Setup [02][04]
   - Pakiety: `bank.bank.domain`, `bank.bank.service`, `bank.app`, `bank.bank.util`. [04]
   - `bank.app.Main` z `main`. [03]
2. Abstrakcja konta [08]
   - `abstract class Account` (nr, właściciel, saldo). [08]
   - `CheckingAccount`, `SavingsAccount` (różne zasady naliczania opłat/odsetek). [07]
3. Interfejsy [08]
   - `bank.domain.Transactable` (`deposit()`, `withdraw()`, `transferTo()`). [08]
   - `bank.domain.Exportable` (historia operacji do CSV). [08]
4. Karty i autoryzacje [05b][07]
   - `bank.domain.Card` (nr, limit dzienny), podklasy: `DebitCard`, `VirtualCard`. [07]
   - Prosta weryfikacja limitów. [06]
5. Serwisy [03]
   - `bank.service.AccountService`, `bank.service.TransferService` (przelewy, validacje). [03]
6. Modyfikatory/kapsułkowanie [05]
   - Prywatne pola, kontrola stanu, niemodyfikowalne widoki. [05]
7. Polimorfizm [07]
   - Różne typy kont implementują inaczej opłaty/odsetki. [07]
8. Demo [03]
   - Utwórz konta, wykonaj wpłaty/przelewy, wygeneruj wyciąg CSV. [03]
9. Rozszerzenia (opcjonalnie) [07][08]
   - `FeePolicy` i `InterestPolicy` jako strategie. [08]
   - `abstract FraudDetector` z prostą implementacją. [07]
10. GitHub [02]
    - Repo, `.gitignore`, `README.md` z przykładowym wyciągiem. [02]
