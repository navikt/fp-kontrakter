# fp-kontrakter

Central contract and DTO library for inter-service communication in the foreldrepenger ecosystem.

## Shared context

- Source of truth for shared domain, architecture, and conventions: `navikt/fp-context`
- Copilot Space: `navikt/TeamForeldrepenger`

## Repo-specific context

| Topic      | Details                                                                              |
|------------|--------------------------------------------------------------------------------------|
| Role       | Owns versioned contracts for Rest-integrations, Kafka topics, and some XML documents |
| Consumers  | Backends in the Team Foreldrepenger ecosystem                                        |
| Tech stack | Java SemVer library; some XSD-based code generation                                  |

Use `fp-kontrakter` primarily for multi-consumer artifacts / multi-lateral contracts. 
Other bi-lateral rest contract dtos are published by service producers: `fp-abakus`, `fp-kalkulus`, `fp-inntektsmelding`, `fp-soknad`.

## Contents

- `hendelser-behandling`: DTOs for Json Kafka topic `behandling-hendelse`
- `fp-kontrakt-felles`: value objects, enums and validation used across multiple contracts
- `fordel-v1`, `abonnent-v2`, `fp-formidling-v1`, `fp-oversikt`, `risk-v1`, `fp-ws-proxy-v1`, `simulering-resultat`: Rest contract DTOs
- `soknad-pom`: Søknad XML documents archived in Joark
- `inntektsmelding-v1`: Inntektsmelding XML documents archived in Joark
- `behandlingsprosess-vedtak-pom`: Vedtak XML representation stored by `fp-sak`
- `okekonomi-pom`: XML contracts for use with JMS/MQ to/from OS

## Verification

- Verify contract changes in the relevant consumers, especially where events or external schemas are persisted or published.
