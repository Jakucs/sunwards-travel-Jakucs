# Sunwards Travel: Summer Itinerary Engine

## Context

You have just joined the engineering team at Sunwards Travel, a small agency that spent the last twenty years booking summer holidays on paper. Their filing cabinets are full, their star travel agent is retiring in October, and every price rule she knows lives only in her head. Your job is to build the engine that replaces those cabinets — a system that assembles holidays out of individual bookings, prices them correctly, and knows exactly what a customer gets back when plans fall apart.

Get this wrong and someone lands in Crete with an unpaid hotel.

> **INTERNAL MEMO — Sunwards Travel, Operations Handbook (final revision before digitisation)**
>
> All money in this agency is handled in euros and written with exactly **2 decimal places**, always **rounded half up**. A booking's price is rounded the moment it is reported, and every total we quote is built from those already-rounded booking prices. Never print a raw fraction to a customer.
>
> Every booking we take gets a reference number. References are assigned sequentially starting from `5001`, and once a booking has a reference that reference never changes, not even if the trip is rebuilt from scratch.
>
> We sell three kinds of bookings and each one is priced its own way.
> - **Flights** cost a base fare per seat. Add **`45.00`** per checked bag. Bags are counted for the whole booking, not per passenger.
> - **Accommodation** costs a nightly rate multiplied by the number of nights, multiplied by the number of rooms. A stay of **`7`** nights or more earns a **`10%`** discount off that accommodation total — the "long stay" rule.
> - **Excursions** cost a per-person price. Children under **`12`** years old travel on excursions at **half price**. Adults pay full price.
>
> Every holiday belongs to exactly one category, and the category is written in our records in full capitals, never abbreviated: `"BEACH"`, `"CITY_BREAK"`, `"MOUNTAIN"`. Anything else is not a category we sell.
>
> We never write a booking for zero seats, zero nights or zero rooms, we never file a holiday for zero travellers, and we never write anything down with a negative fare, a negative bag count or a negative headcount. Margit's rule, framed above her desk: *if the form does not make sense, refuse it — do not quietly fix it.*
>
> Each customer's holiday is filed under its destination, and we only sell one holiday per destination per season — so a destination names exactly one holiday, while a reference names exactly one booking inside it.
>
> No single itinerary may hold more than **`10`** bookings, cancelled ones included — they stay on file and still take up a slot. When Margit tried to sell a fourteen-stop tour of the Adriatic in 2011 the printer jammed and we lost the entire booking. Ten is the limit.
>
> **On cancellations.** Not everything we sell can be cancelled. When a customer calls to cancel, the agent notes how many days are left before departure and applies the window: **`14`** days or more and the customer is refunded **`80%`** of what that booking cost; inside those 14 days the refund drops to **`25%`**. Flights are never refundable — once a ticket is issued the money is gone, and we tell the customer the truth. Accommodation and excursions can both be cancelled.
>
> A cancelled booking stays in the itinerary as a record, but it no longer counts towards the price of the holiday. Refunds are always calculated on the booking's own price, before any group discount — the group discount is a goodwill gesture on the whole holiday, not on the individual booking.
>
> **On groups.** A holiday carrying **`8`** or more travellers is a group booking and receives a further **`5%`** off the total price of the whole holiday. This group discount is applied last, after every individual booking has been priced and after the long-stay discount. The traveller count on the holiday is the customer's party size; individual bookings carry their own headcounts and we do not cross-check the two.
>
> **On the season's records.** When two holidays are worth the same, we quote the one we booked first. A season with nothing on file has no most expensive holiday and no answer to give — say so rather than invent a figure. The combined value of a season with nothing on file is `0.00`.
>
> **A worked example, for the trainees.** Crete, category `"BEACH"`, party of 5 adults and 3 children — 8 travellers, so a group booking.
>
> | Booking | Working | Reported |
> |---|---|---|
> | Flight | `120.00` × 6 seats + `45.00` × 3 bags = 720.00 + 135.00 | **855.00** |
> | Accommodation | `85.50` × 7 nights × 2 rooms = 1197.00, long stay −10% | **1077.30** |
> | Excursion | 5 × `24.99` + 3 × `12.495` (half price) = 162.435 | **162.44** |
>
> Only 6 seats for a party of 8 — two of them drove down and met the others at the hotel. That is normal and nobody checks it. Those three reported prices add up to `2094.74`. The party is 8, so take `5%` off: `2094.74 × 0.95 = 1990.0030`, which we quote as **`1990.00`**.
>
> Now the customer cancels the excursion `20` days before departure. That is 14 or more, so the refund is `80%` of `162.44` = `129.9520`, paid out as **`129.95`**. The excursion no longer counts, so the holiday is now `855.00 + 1077.30 = 1932.30`, less `5%` = **`1835.69`**. Had the customer cancelled inside the 14-day window instead, the refund would have been `25%` of `162.44` = **`40.61`**.

## Exam Rules & Circumstances

- You have **3 hours** to complete this assignment.
- Follow proper git commit practices: commits must be atomic and descriptive. A single final commit is not acceptable.
- This is an individual task. Do not use AI tools or any external sources.
- You must submit code you fully understand and can explain in detail.

## What You'll Need

Knowledge of: Java basics, OOP basics, SOLID principles.

## Your Tasks

### Task 1: The Booking Ledger

Everything Sunwards sells is a booking, and every booking behaves the same way in some respects and differently in others. Your first job is to find what they share.

- Every booking you create carries a booking reference and can report what it costs. References are handed out sequentially from `5001` in the order bookings are created, and a reference that can still be changed afterwards is not acceptable.
- Your bookings report their price in euros, rounded to 2 decimal places, half up. Each kind calculates that price differently, following the rules in the memo.
- A flight booking knows its base fare per seat, its seat count and how many checked bags were added.
- An accommodation booking knows its nightly rate, its number of nights and its number of rooms. The long-stay discount applies automatically once the night count reaches the threshold.
- An excursion booking knows its per-person price, how many adults are attending and how many children under 12 are attending.
- Refusing nonsensical input is part of the job. Each of the following must signal an error at the moment you create the booking, and silently correcting the value to zero — or accepting it and failing later — is not acceptable:
  - a negative fare, nightly rate or per-person price
  - a zero or negative seat count, night count or room count
  - a negative bag count, adult count or child count
- Asking any booking what it costs must work without you knowing which kind of booking you are holding.

**Note:** You may need to create additional types beyond what is described here. Think carefully about where shared behaviour belongs and how to avoid duplication.

### Task 2: What Can Be Undone

Some of what Sunwards sells can be given back and some of it cannot. Your system needs to know which is which.

- Flights are never refundable. Once a ticket is issued the money is gone, and only accommodation and excursions can be cancelled.
- A booking that can be cancelled tells you whether it currently is cancelled.
- Cancelling needs to know how many days remain before departure, because the refund depends on it: `14` days or more returns `80%` of the booking's own price, fewer than `14` days returns `25%`. Both amounts are rounded to 2 decimals, half up.
- Cancelling a booking that is already cancelled must signal an error — a customer cannot collect two refunds for one hotel.
- Cancelling with a negative number of days remaining must signal an error.

### Task 3: The Itinerary

An itinerary is one customer's holiday: a destination, a category, a party of travellers, and the bookings that make it up.

- Your itinerary holds a destination name, a category (`"BEACH"`, `"CITY_BREAK"` or `"MOUNTAIN"`), a number of adult travellers and a number of child travellers. A category outside those three must signal an error.
- Bookings go in one at a time. Adding an eleventh booking must signal an error, and cancelled bookings still occupy their slot.
- Your itinerary reports its total price: the sum of the reported prices of every booking that has not been cancelled, with the `5%` group discount applied to that sum when the party totals `8` or more travellers. Cancelled bookings contribute nothing.
- Your itinerary reports how many bookings it holds and how many of those are cancelled.
- Your itinerary hands back the booking matching a given reference. Asking for a reference it does not hold must signal an error.
- Creating an itinerary with zero travellers, or with a negative number of adults or children, must signal an error. An itinerary with no bookings is fine — it is a holiday still being planned — and its total price is `0.00`.
- The itinerary owns its bookings: handing out its internal collection so that a caller can add or remove bookings behind its back is not acceptable. Handing back one booking on request is fine — that is what the lookup above is for.

### Task 4: Central Booking Desk

The booking desk is what a Sunwards employee actually sits in front of. It holds every itinerary the agency has sold this season and answers questions about them.

- Your desk stores multiple itineraries and takes in new ones. Since only one holiday per destination is sold each season, adding an itinerary for a destination already on file must signal an error.
- Your desk reports the combined value of every itinerary it holds. An empty desk reports `0.00`.
- Your desk lists every itinerary in a given category. A category with nothing in it returns an empty result, not an error.
- Your desk finds the single most expensive itinerary. If two are equally expensive, the one added first wins. Asking an empty desk must signal an error.
- Your desk cancels a specific booking inside a specific itinerary, given the destination, the booking reference and the days remaining, and reports the refund. An unknown destination must signal an error, and so must an attempt to cancel a booking that is not refundable — quietly returning zero is not acceptable.

## Technical Requirements

- This assignment targets Java 25.
- All fields must be properly encapsulated. Public mutable state is not acceptable.
- Values that must not change after construction must be enforced as such by the language, not merely documented in a comment.
- Polymorphism must do the dispatching. Branching on which of the three kinds of booking you are holding is not acceptable. Asking whether a booking supports cancellation at all is fine — that is a different question.
- Absent or failed lookups must be signalled with an exception, never by returning `null` or a placeholder value. You are not required to use `Optional`.
- Error conditions must be signalled with exceptions carrying a message that explains what went wrong.
- Monetary amounts are rounded to 2 decimal places, half up, at the point they are reported, and totals are built from those already-rounded figures. Rounding must happen in one place, not be repeated at every call site.

## Deliverables (GitHub repository)

1. All source files with functionality implemented
2. A working build file (`pom.xml` or `build.gradle`) — no external dependencies are required
3. A runnable entry point demonstrating one full itinerary, one cancellation and one group discount
4. All code must compile and run without errors
